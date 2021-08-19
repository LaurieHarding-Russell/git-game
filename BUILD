java_binary(
    name = "GitGame",
    srcs = ["src/GitGame.java"],
    jvm_flags = ["-Dorg.lwjgl.util.DebugLoader=true"],
    main_class = "src.GitGame",
    deps = [
        "@maven//:org_lwjgl_lwjgl",
        "@maven//:org_lwjgl_lwjgl_assimp",
        "@maven//:org_lwjgl_lwjgl_glfw",
        "@maven//:org_lwjgl_lwjgl_openal",
        "@maven//:org_lwjgl_lwjgl_opengl",
        "@maven//:org_lwjgl_lwjgl_stb",
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