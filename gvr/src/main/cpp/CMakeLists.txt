cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

add_library(gvr SHARED
            gvrtest.cpp
            UnityInterface.cpp
            LogMessage.cpp
            gvrfn.cpp)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(gvr log android)
