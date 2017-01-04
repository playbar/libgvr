cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(gvr SHARED src/UnityInterface.cpp)

# copy out the lib binary and remove generated files
set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../hello-libs/distribution)

set_target_properties(gvr
                      PROPERTIES
                      LIBRARY_OUTPUT_DIRECTORY
                      "${distribution_DIR}/gvr/lib/${ANDROID_ABI}")

add_custom_command(TARGET gvr POST_BUILD
                   COMMAND "${CMAKE_COMMAND}" -E
                   copy "${CMAKE_CURRENT_SOURCE_DIR}/src/UnityInterface.h"
                   "${distribution_DIR}/gvr/include/UnityInterface.h"
                   COMMAND "${CMAKE_COMMAND}" -E
                   remove_directory "${CMAKE_CURRENT_BINARY_DIR}"
                   COMMENT "Copying gvr to output directory")

