#ifndef __GLRESOURCE_H__
#define __GLRESOURCE_H__


#ifdef __cplusplus
extern "C" {
#endif

typedef enum {
    TEX_STATUS_NONE,
    TEX_STATUS_BEGIN,
    TEX_STATUS_END,
    TEX_STATUS_DONE
}TEX_STATUS;

typedef struct{
    int tid;
    int width;
    int height;
    void *buffer;
    void *eglImage;
    int textureid;
    TEX_STATUS texStatus;
}MJTexture;

extern int gIndex;
extern MJTexture gMJTexture[10];

#ifdef __cplusplus
}
#endif


#endif

