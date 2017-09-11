cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

ADD_DEFINITIONS(-DEGL_EGLEXT_PROTOTYPES)
ADD_DEFINITIONS(-DGL_GLEXT_PROTOTYPES)

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
                      GLESv2
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
            gvrhook/mjgvr.cc
            CallStack.cpp
            syscallstack.cc
            )
target_include_directories(gvrhook PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          ${CMAKE_CURRENT_SOURCE_DIR}/gvrhook )

target_link_libraries(gvrhook gvr log)

#############################################
add_library(hook SHARED
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

target_include_directories(hook PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR}
                          )

# Include libraries needed for hello-jnicallback lib
target_link_libraries(hook
                     log
                     android
                     vulkan
                     GLESv3
                     EGL)



################################
add_library(draw SHARED
            treasure_hunt_jni.cc
            treasure_hunt_renderer.cc)

add_library(lib_audio SHARED IMPORTED )
set_target_properties(lib_audio PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr_audio.so)

#add_library(lib_gvr SHARED IMPORTED )
#set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
#    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(draw log android  EGL GLESv2 gvr lib_audio)
