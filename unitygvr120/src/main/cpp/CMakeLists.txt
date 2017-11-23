cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -fPIC  -shared")

add_library(gvr_back SHARED
            gvrglobal.cpp
            gvrInter.cpp
            LogMessage.cpp
            gvrfn.cpp)

# Include libraries needed for hello-jnicallback lib
target_link_libraries(gvr_back log android GLESv2)

###########################

add_library(lib_gvr SHARED IMPORTED)
set_target_properties(lib_gvr PROPERTIES IMPORTED_LOCATION
    ${CMAKE_CURRENT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libgvr.so)

add_library(gvrhook SHARED
            eglhook/elf_common.cpp
            eglhook/elf_hooker.cpp
            eglhook/elf_eglhook.cpp
            eglhook/elf_module.cpp
            gvrhook.cpp
            detour.cpp
            instruction.cpp
            HookBase.cpp
            HookGVRTools.cpp
            )
target_link_libraries(gvrhook
                      lib_gvr
                      log
                      EGL
                      GLESv2)

