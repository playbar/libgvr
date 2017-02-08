cmake_minimum_required(VERSION 3.4.1)

add_library(mjtest SHARED
            hello-jni.c)

# Include libraries needed for mjtest lib
target_link_libraries(mjtest log android)
