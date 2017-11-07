#include <GLES2/gl2.h>
#include <malloc.h>
#include <cstdlib>
#include "drawtex.h"
#include "gvrhookfn.h"

UserData gUserData;

static void CheckGLError(const char* label) {
    int gl_error = glGetError();
    if (gl_error != GL_NO_ERROR) {
        LOGE("GL error @ %s: %d", label, gl_error);
        // Crash immediately to make OpenGL errors obvious.
//        abort();
    }
}

GLuint  esLoadShader ( GLenum type, const char *shaderSrc )
{
    GLuint shader;
    GLint compiled;

// Create the shader object
    shader = glCreateShader ( type );

    if ( shader == 0 )
    {
        return 0;
    }

// Load the shader source
    glShaderSource ( shader, 1, &shaderSrc, NULL );

// Compile the shader
    glCompileShader ( shader );

// Check the compile status
    glGetShaderiv ( shader, GL_COMPILE_STATUS, &compiled );

    if ( !compiled )
    {
        GLint infoLen = 0;

        glGetShaderiv ( shader, GL_INFO_LOG_LENGTH, &infoLen );

        if ( infoLen > 1 )
        {
            char *infoLog = (char*)malloc ( sizeof ( char ) * infoLen );

            glGetShaderInfoLog ( shader, infoLen, NULL, infoLog );
            free ( infoLog );
        }

        glDeleteShader ( shader );
        return 0;
    }

    return shader;

}


//
///
/// \brief Load a vertex and fragment shader, create a program object, link program.
//         Errors output to log.
/// \param vertShaderSrc Vertex shader source code
/// \param fragShaderSrc Fragment shader source code
/// \return A new program object linked with the vertex/fragment shader pair, 0 on failure
//
GLuint esLoadProgram ( const char *vertShaderSrc, const char *fragShaderSrc )
{
    GLuint vertexShader;
    GLuint fragmentShader;
    GLuint programObject;
    GLint linked;

    // Load the vertex/fragment shaders
    vertexShader = esLoadShader ( GL_VERTEX_SHADER, vertShaderSrc );

    if ( vertexShader == 0 )
    {
        return 0;
    }

    fragmentShader = esLoadShader ( GL_FRAGMENT_SHADER, fragShaderSrc );

    if ( fragmentShader == 0 )
    {
        glDeleteShader ( vertexShader );
        return 0;
    }

    // Create the program object
    programObject = glCreateProgram ( );

    if ( programObject == 0 )
    {
        return 0;
    }

    glAttachShader ( programObject, vertexShader );
    glAttachShader ( programObject, fragmentShader );

    // Link the program
    glLinkProgram ( programObject );

    // Check the link status
    glGetProgramiv ( programObject, GL_LINK_STATUS, &linked );

    if ( !linked )
    {
        GLint infoLen = 0;

        glGetProgramiv ( programObject, GL_INFO_LOG_LENGTH, &infoLen );

        if ( infoLen > 1 )
        {
            char *infoLog = (char *)malloc ( sizeof ( char ) * infoLen );
            glGetProgramInfoLog ( programObject, infoLen, NULL, infoLog );
            free ( infoLog );
        }

        glDeleteProgram ( programObject );
        return 0;
    }

    // Free up no longer needed shader resources
    glDeleteShader ( vertexShader );
    glDeleteShader ( fragmentShader );

    return programObject;
}


GLuint createTexture( )
{
    // Texture object handle
    GLuint textureId;

    // 2x2 Image, 3 bytes per pixel (R, G, B)
    GLubyte pixels[4 * 3] =
            {
                    255,   0,   0, // Red
                    0, 255,   0, // Green
                    0,   0, 255, // Blue
                    255, 255,   0  // Yellow
            };

    // Use tightly packed data
    glPixelStorei ( GL_UNPACK_ALIGNMENT, 1 );

    // Generate a texture object
    glGenTextures ( 1, &textureId );

    // Bind the texture object
    glBindTexture ( GL_TEXTURE_2D, textureId );

    // Load the texture
    glTexImage2D ( GL_TEXTURE_2D, 0, GL_RGB, 2, 2, 0, GL_RGB, GL_UNSIGNED_BYTE, pixels );

    // Set the filtering mode
    glTexParameteri ( GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST );
    glTexParameteri ( GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST );

    glBindTexture(GL_TEXTURE_2D, 0);

    return textureId;

}



///
// Initialize the shader and program object
//
int InitTex( UserData *userData)
{
    char vShaderStr[] =
            "#version 300 es                            \n"
            "layout(location = 0) in vec4 a_position;   \n"
            "layout(location = 1) in vec2 a_texCoord;   \n"
            "out vec2 v_texCoord;                       \n"
            "void main()                                \n"
            "{                                          \n"
            "   gl_Position = a_position;               \n"
            "   v_texCoord = a_texCoord;                \n"
            "}                                          \n";

    char fShaderStr[] =
            "#version 300 es                                     \n"
            "precision mediump float;                            \n"
            "in vec2 v_texCoord;                                 \n"
            "layout(location = 0) out vec4 outColor;             \n"
            "uniform sampler2D s_texture;                        \n"
            "void main()                                         \n"
            "{                                                   \n"
            "  outColor = texture( s_texture, v_texCoord );   \n"
            "}                                                   \n";

    // Load the shaders and get a linked program object
    userData->programObject = esLoadProgram ( vShaderStr, fShaderStr );

//   GLsizei len = 1000;
//    GLchar data[1000];
//   glGetShaderSource(userData->programObject, 1, &len, data );

    // Get the sampler location
    userData->samplerLoc = glGetUniformLocation ( userData->programObject, "s_texture" );

    // Load the texture
    userData->textureId = createTexture ();
    CheckGLError("InitTex");

    glClearColor ( 1.0f, 1.0f, 1.0f, 0.0f );

    return true;
}


void DrawTex( UserData *userData)
{
    CheckGLError("drawtex begin");
    GLfloat vVertices[] = { -0.5f,  0.5f, 0.0f,  // Position 0
                            0.0f,  0.0f,        // TexCoord 0
                            -0.5f, -0.5f, 0.0f,  // Position 1
                            0.0f,  1.0f,        // TexCoord 1
                            0.5f, -0.5f, 0.0f,  // Position 2
                            1.0f,  1.0f,        // TexCoord 2
                            0.5f,  0.5f, 0.0f,  // Position 3
                            1.0f,  0.0f         // TexCoord 3
    };
    GLushort indices[] = { 0, 1, 2, 0, 2, 3 };

    // Set the viewport
//    glViewport ( 0, 0, esContext->width, esContext->height );

    // Clear the color buffer
    glClear ( GL_COLOR_BUFFER_BIT );

    // Use the program object
    glUseProgram ( userData->programObject );

    // Load the vertex position
    glEnableVertexAttribArray ( 0 );
    glVertexAttribPointer ( 0, 3, GL_FLOAT, GL_FALSE, 5 * sizeof ( GLfloat ), vVertices );
    // Load the texture coordinate

    glEnableVertexAttribArray ( 1 );
    glVertexAttribPointer ( 1, 2, GL_FLOAT, GL_FALSE, 5 * sizeof ( GLfloat ), &vVertices[3] );


    // Bind the texture
//    glEnable(GL_TEXTURE_2D);
    glActiveTexture ( GL_TEXTURE0 );
    glBindTexture ( GL_TEXTURE_2D, userData->textureId );
//    glBindImageTexture(0, userData->textureId, 0, GL_FALSE, 0, GL_READ_ONLY, GL_R32F);


    // Set the sampler texture unit to 0
    glUniform1i ( userData->samplerLoc, 0 );

    glDrawElements ( GL_TRIANGLES, 6, GL_UNSIGNED_SHORT, indices );

    glDisableVertexAttribArray ( 0 );
    glDisableVertexAttribArray ( 1 );

    CheckGLError("drawtex");
//    glDrawArrays ( GL_POINTS, 0, 6 );
}

void ShutDownTex ( UserData *userData )
{
    // Delete texture object
    glDeleteTextures ( 1, &userData->textureId );
    // Delete program object
    glDeleteProgram ( userData->programObject );
}

