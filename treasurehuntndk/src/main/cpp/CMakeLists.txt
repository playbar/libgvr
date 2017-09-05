cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

################################
add_library(draw SHARED
            treasure_hunt_jni.cc
            treasure_hunt_renderer.cc)

target_include_directories(draw PRIVATE
                          ${CMAKE_CURRENT_SOURCE_DIR} )

add_library(lib_audio SHARED IMPORTED )
set_target_properties(lib_audio PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr_audio.so)

add_library(lib_gvr SHARED IMPORTED )
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(draw log android  EGL GLESv2 lib_gvr lib_audio)
