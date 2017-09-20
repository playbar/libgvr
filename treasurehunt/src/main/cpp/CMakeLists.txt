cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

ADD_DEFINITIONS(-DEGL_EGLEXT_PROTOTYPES)
ADD_DEFINITIONS(-DGL_GLEXT_PROTOTYPES)


add_library(png SHARED
            libpng/png.c
            libpng/pngerror.c
            libpng/pngget.c
            libpng/pngmem.c
            libpng/pngpread.c
            libpng/pngread.c
            libpng/pngrio.c
            libpng/pngrtran.c
            libpng/pngrutil.c
            libpng/pngset.c
            libpng/pngtest.c
            libpng/pngtrans.c
            libpng/pngwio.c
            libpng/pngwrite.c
            libpng/pngwtran.c
            libpng/pngwutil.c
            libpng/pngutils.c)
target_link_libraries(png
                      log
                      z)

 #######################################

 add_library(texresource SHARED
             glresource.c)
 target_link_libraries(texresource
                       log
                       png
                       GLESv3)



########################################

add_library(gvr SHARED
            gvrglobal.cpp
            gvrInter.cpp
            syscallstack.cc
            LogMessage.cpp)

target_include_directories(gvr PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          )

# Include libraries needed for hello-jnicallback lib
target_link_libraries(gvr
                      log
                      android
                      GLESv3
                      EGL)

##############################################

add_library(lib_gvr SHARED IMPORTED)
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${CMAKE_CURRENT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

add_library(gvrhook SHARED
            gvrhook/gvrhook.cpp
            gvrhook/detour.cpp
            gvrhook/instruction.cpp
            gvrhook/gvrhookfn.cpp
            gvrhook/graphicshook.cpp
            gvrhook/mjgvr.cc
            CallStack.cpp
            syscallstack.cc
            )
target_include_directories(gvrhook PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          ${CMAKE_CURRENT_SOURCE_DIR}/gvrhook )

target_link_libraries(gvrhook gvr log texresource)

#############################################
add_library(glhook SHARED
               gleshook/inlineHook.c
               gleshook/hookutils.c
               gleshook/relocate.c
               gleshook/eglexthook.c
               gleshook/gl2exthook.c
               gleshook/eglhook.c
               gleshook/gleshook.c
               gleshook/threadhook.c
               gleshook/vkhook.c
               gleshook/callstack.c
               syscallstack.cc)

target_include_directories(glhook PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          )

# Include libraries needed for hello-jnicallback lib
target_link_libraries(glhook
                     log
                     android
                     vulkan
                     texresource
                     GLESv3
                     EGL)



################################
add_library(draw SHARED
            treasure_hunt_jni.cc
            treasure_hunt_renderer.cc
             syscallstack.cc)

target_include_directories(draw PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          )

add_library(lib_audio SHARED IMPORTED )
set_target_properties(lib_audio PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr_audio.so)

#add_library(lib_gvr SHARED IMPORTED )
#set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
#    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(draw
                      log
                      android
                      EGL
                      GLESv3
                      gvr
                      lib_audio
                      texresource)
