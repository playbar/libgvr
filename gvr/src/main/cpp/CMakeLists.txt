cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

add_library(gvr SHARED
            jnicallback.c
            UnityInterface.cpp
            gvrfn.cpp)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(gvr log android)
