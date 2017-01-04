
cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

# configure import libs
# source code are under gen-libs module(it is buildable)

set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../distribution)

#LINK_DIRECTORIES(${distribution_DIR}/gmath/lib/${ANDROID_ABI})

add_library(lib_gmath STATIC IMPORTED )
set_target_properties(lib_gmath PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gmath/lib/${ANDROID_ABI}/libgmath.a)

# shared lib will also be tucked into APK and sent to target
# ${ANDROID_ABI} is handy for our purpose here. Probably this ${ANDROID_ABI} is
# the most valuable thing of this sample, the rest are pretty much normal cmake

add_library(lib_gperf SHARED IMPORTED )
set_target_properties(lib_gperf PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gperf/lib/${ANDROID_ABI}/libgperf.so)

add_library(lib_gvr SHARED IMPORTED )
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gvr/lib/${ANDROID_ABI}/libgvr.so)

# build application's shared lib
include_directories(${distribution_DIR}/gmath/include
                    ${distribution_DIR}/gperf/include)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

add_library(hello-libs SHARED hello-libs.cpp)

target_link_libraries(hello-libs log android lib_gmath lib_gperf)

