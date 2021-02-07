load("@npm//@angular-devkit/architect-cli:index.bzl", "architect", "architect_test")

# Server

cc_binary(
    name = "GitGame",
    srcs = [
        "Server/GitGameServerApp.cpp",
        "Server/GameController.h",
        "Server/GameController.cpp",
    ],
    deps = [
        "@boost//:system",
        "@boost//:asio",
        "@boost//:date_time",
        "@boost//:uuid",
        "@com_github_served//:served",
    ],
    visibility = ["//visibility:public"]
)

cc_binary(
    name = "GitGameProd",
    srcs = [
        "Server/GitGaneServerApp.cpp",
        "Server/GameController.h",
        "Server/GameController.cpp",
    ],
    deps = [
        "@boost//:system",
        "@boost//:asio",
        "@boost//:date_time",
        "@boost//:uuid",
        "@com_github_served//:served",
    ],
    includes = [
        ":build_prod"
    ],
    visibility = ["//visibility:public"]
)

# UI

# These dependencies are needed for any ng command
filegroup(
    name = "common_deps",
    srcs = [
        "angular.json",
        "tsconfig.json",
    ],
    visibility = ["//:__subpackages__"],
)

APPLICATION_DEPS = [
    "//:common_deps",
    "@npm//@angular/cli",
    "@npm//@angular/core",
    "@npm//@angular/router",
    "@npm//@angular/platform-browser-dynamic",
    "@npm//@angular-devkit/build-angular",
    "@npm//rxjs",
    "@npm//mime",
    "@npm//zone.js",
    "@npm//tslib",
    "@npm//typescript",
]

architect(
    name = "build",
    args = [
        "UI:build",
        "--outputPath=$(@D)",
    ],
    configuration_env_vars = ["NG_BUILD_CACHE"],
    data = glob(
        [
            "UI/src/**/*",
        ],
        exclude = [
            "UI/src/**/*.spec.ts",
            "UI/src/test.ts",
        ],
    ) + APPLICATION_DEPS + [
        "tsconfig.app.json",
    ],
    output_dir = True,
)

architect(
    name = "build_prod",
    args = [
        "UI:build", 
        "--outputPath=$(@D)",
    ],
    configuration_env_vars = ["NG_BUILD_CACHE"],
    data = glob(
        [
            "UI/src/**/*",
        ],
        exclude = [
            "UI/src/**/*.spec.ts",
            "UI/src/test.ts",
        ],
    ) + APPLICATION_DEPS + [
        "tsconfig.app.json",
    ],
    output_dir = True,
)

architect_test(
    name = "test",
    args = [
        "UI:serve",
    ],
    configuration_env_vars = ["NG_BUILD_CACHE"],
    data = glob([
        "UI/src/**/*",
    ]) + APPLICATION_DEPS + [
        "karma.conf.js",
        "tsconfig.spec.json",
        "@npm//@types/jasmine",
        "@npm//@types/node",
        "@npm//karma",
        "@npm//karma-chrome-launcher",
        "@npm//karma-coverage-istanbul-reporter",
        "@npm//karma-jasmine",
        "@npm//karma-jasmine-html-reporter",
    ],
    tags = [
        "browser:chromium-local",
        "no-bazelci-mac",
    ],
)

# architect_test(
#     name = "e2e",
#     args = [
#         "UI:e2e",
#         "--no-webdriverUpdate",
#     ],
#     configuration_env_vars = ["NG_BUILD_CACHE"],
#     data = glob([
#         "UI/src/*",
#         "UI/src/**",
#         "UI/e2e/*",
#         "UI/e2e/**",
#     ]) + APPLICATION_DEPS + [
#         "tsconfig.app.json",
#         "@npm//protractor",
#         "@npm//jasmine-spec-reporter",
#         "@npm//ts-node",
#         "@npm//@types/jasmine",
#         "@npm//@types/jasminewd2",
#         "@npm//@types/node",
#     ],
#     tags = [
#         "browser:chromium-local",
#         "no-bazelci-mac",
#     ],
# )

architect(
    name = "lint",
    data = glob([
        "UI/src/**/*",
        "UI/e2e/src/**/*",
    ]) + [
        "//:common_deps",
        "tsconfig.spec.json",
        "tsconfig.app.json",
        "tslint.json",
        "UI/e2e/tsconfig.json",
        "@npm//@angular/cli",
        "@npm//@angular-devkit/build-angular",
        "@npm//codelyzer",
        "@npm//tslint",
    ],
)

architect(
    name = "serve",
    args = [
        "UI:serve",
    ],
    configuration_env_vars = ["NG_BUILD_CACHE"],
    data = glob(
        [
            "UI/src/*",
            "UI/src/**",
        ],
        exclude = [
            "UI/src/**/*.spec.ts",
            "UI/src/test.ts",
        ],
    ) + APPLICATION_DEPS + [
        "tsconfig.app.json",
    ],
    tags = ["ibazel_notify_changes"],
)

architect(
    name = "serve_prod",
    configuration_env_vars = ["NG_BUILD_CACHE"],
    data = glob(
        [
            "UI/src/*",
            "UI/src/**",
        ],
        exclude = [
            "UI/src/**/*.spec.ts",
            "UI/src/test.ts",
        ],
    ) + APPLICATION_DEPS + [
        "tsconfig.app.json",
    ],
    tags = ["ibazel_notify_changes"],
)