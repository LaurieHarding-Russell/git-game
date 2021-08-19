load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_file")

RULES_JVM_EXTERNAL_TAG = "4.0"

RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

LWJGL_VERSION = "3.2.3"

maven_install(
    artifacts = [
        "org.lwjgl:lwjgl:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-assimp:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-glfw:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-openal:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-opengl:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-stb:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-assimp::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-glfw::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-openal::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-opengl::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-stb::natives-macos:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-assimp::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-glfw::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-openal::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-opengl::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-stb::natives-linux:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl::natives-windows:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-assimp::natives-windows:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-glfw::natives-windows:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-openal::natives-windows:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-opengl::natives-windows:" + LWJGL_VERSION,
        "org.lwjgl:lwjgl-stb::natives-windows:" + LWJGL_VERSION,
    ],
    maven_install_json = "//:maven_install.json",
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
