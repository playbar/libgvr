cmake_minimum_required(VERSION 3.4.1)

#set(CMAKE_BUILD_TYPE "Release")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

ADD_DEFINITIONS(-DEGL_EGLEXT_PROTOTYPES)
ADD_DEFINITIONS(-DGL_GLEXT_PROTOTYPES)

add_library(lib_gvr SHARED IMPORTED)
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${CMAKE_CURRENT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

add_library(lib_audio SHARED IMPORTED )
set_target_properties(lib_audio PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr_audio.so)

add_library(treasurehunt_jni SHARED
            treasure_hunt_jni.cc
            treasure_hunt_renderer.cc
            )

target_include_directories(treasurehunt_jni PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          )

target_link_libraries(treasurehunt_jni
                      log
                      android
                      EGL
                      GLESv2
                      lib_gvr
                      lib_audio
                      )
