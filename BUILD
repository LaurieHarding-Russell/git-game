java_binary(
    name = "game",
    srcs = glob(["src/**/*.java"]),
    main_class = "src.GitGame",
    deps = [
        "@maven//:org_lwjgl_lwjgl",
        "@maven//:org_lwjgl_lwjgl_assimp",
        "@maven//:org_lwjgl_lwjgl_glfw",
        "@maven//:org_lwjgl_lwjgl_openal",
        "@maven//:org_lwjgl_lwjgl_opengl",
        "@maven//:org_lwjgl_lwjgl_stb",
        "@maven//:org_eclipse_jgit_org_eclipse_jgit",
        "@maven//:com_google_guava_guava",
        ":lombok",
    ] + select({
        "@bazel_tools//src/conditions:windows": [
            "@maven//:org_lwjgl_lwjgl_assimp_natives_windows",
            "@maven//:org_lwjgl_lwjgl_glfw_natives_windows",
            "@maven//:org_lwjgl_lwjgl_natives_windows",
            "@maven//:org_lwjgl_lwjgl_openal_natives_windows",
            "@maven//:org_lwjgl_lwjgl_opengl_natives_windows",
            "@maven//:org_lwjgl_lwjgl_stb_natives_windows",
        ],
        "@bazel_tools//src/conditions:linux_x86_64": [
            "@maven//:org_lwjgl_lwjgl_assimp_natives_linux",
            "@maven//:org_lwjgl_lwjgl_glfw_natives_linux",
            "@maven//:org_lwjgl_lwjgl_natives_linux",
            "@maven//:org_lwjgl_lwjgl_openal_natives_linux",
            "@maven//:org_lwjgl_lwjgl_opengl_natives_linux",
            "@maven//:org_lwjgl_lwjgl_stb_natives_linux",
        ],
        "@bazel_tools//src/conditions:darwin_x86_64": [
            "@maven//:org_lwjgl_lwjgl_assimp_natives_macos",
            "@maven//:org_lwjgl_lwjgl_glfw_natives_macos",
            "@maven//:org_lwjgl_lwjgl_natives_macos",
            "@maven//:org_lwjgl_lwjgl_openal_natives_macos",
            "@maven//:org_lwjgl_lwjgl_opengl_natives_macos",
            "@maven//:org_lwjgl_lwjgl_stb_natives_macos",
        ],
    }),
)

java_library(
    name = "lombok",
    exported_plugins = [":lombok_plugin"],
    exports = ["@maven//:org_projectlombok_lombok"],
)

java_plugin(
    name = "lombok_plugin",
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:org_projectlombok_lombok",
    ],
)
