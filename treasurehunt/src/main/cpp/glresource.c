#include "glresource.h"
#include "libpng/pngutils.h"

int gIndex = 0;
MJTexture gMJTexture[10];

GLuint gTexture;

int gDrawThread = 0;
int gRendThread = 0;

GLuint CreateSimpleTexture2D( )
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

    pic_data data;
//    detect_png("/sdcard/bird.png", &data);
    // Use tightly packed data
    glPixelStorei ( GL_UNPACK_ALIGNMENT, 1 );

    // Generate a texture object
    glGenTextures ( 1, &textureId );

    // Bind the texture object
    glBindTexture ( GL_TEXTURE_2D, textureId );

    // Load the texture
//    glTexImage2D ( GL_TEXTURE_2D, 0, GL_RGB, 2, 2, 0, GL_RGB, GL_UNSIGNED_BYTE, pixels );
    glTexImage2D ( GL_TEXTURE_2D, 0, GL_RGBA, data.width, data.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, data.rgba );

    // Set the filtering mode
    glTexParameteri ( GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST );
    glTexParameteri ( GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST );

    glBindTexture(GL_TEXTURE_2D, 0);

    return textureId;

}
