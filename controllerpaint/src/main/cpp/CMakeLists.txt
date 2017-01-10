cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

add_library(controllerpaint SHARED
            app_jni.cc
            demoapp.cc
            utils.cc)

add_library(lib_gvr SHARED IMPORTED )
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../libs/${ANDROID_ABI}/libgvr.so)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(controllerpaint log android EGL GLESv2 lib_gvr)
