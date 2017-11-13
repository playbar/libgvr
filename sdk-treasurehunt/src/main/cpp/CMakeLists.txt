cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fno-exceptions -Wall -fno-rtti -Wno-error=format-security")

add_library(gvr_back SHARED
            gvrglobal.cpp
            gvrInter.cpp
            LogMessage.cpp
            gvrfn.cpp
            inlineHook.c
            relocate.c
            gleshook.c)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(gvr_back
                      log
                      android
                      GLESv2
                      EGL)

