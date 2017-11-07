#ifndef __DRAWTEX_H__
#define __DRAWTEX_H__

#ifdef __cplusplus
extern "C" {
#endif

typedef struct
{
    // Handle to a program object
    GLuint programObject;

    // Sampler location
    GLint samplerLoc;

    // Texture handle
    GLuint textureId;

} UserData;

GLuint createTexture( );
int InitTex ( UserData *userData);
void DrawTex ( UserData *userData);
void ShutDownTex ( UserData *userData );

extern UserData gUserData;

#ifdef __cplusplus
}
#endif

#endif

