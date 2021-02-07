workspace(
    name = "gitGame",
)

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")



# Server Dependencies
http_archive(
    name = "com_github_nelhage_rules_boost",
    urls = ["https://github.com/nelhage/rules_boost/archive/f32cc980e4dba651594fe364696ceb8b931fcb2d.zip"],
    strip_prefix = "rules_boost-f32cc980e4dba651594fe364696ceb8b931fcb2d",
    sha256 = "b320a69fa414fa5bd6ea9291e8ff5aa7e1bbb9aad6a5c6f23b72c2d7a8ae8fd5"
)

load("@com_github_nelhage_rules_boost//:boost/boost.bzl", "boost_deps")
boost_deps()

http_archive(
    name = "com_github_served",
    urls = ["https://github.com/meltwater/served/archive/8ef95d72692ef1f392fc0a44a6dad4235386ac9d.zip"],
    strip_prefix = "served-8ef95d72692ef1f392fc0a44a6dad4235386ac9d",
    sha256 = "fb97bba7b99125bd12e821ad499cc939d25ccd19614b7ea3a8bb8392b5fbb115"
)

# Angular lazy Bazel

http_archive(
    name = "build_bazel_rules_nodejs",
    sha256 = "dd4dc46066e2ce034cba0c81aa3e862b27e8e8d95871f567359f7a534cccb666",
    urls = ["https://github.com/bazelbuild/rules_nodejs/releases/download/3.1.0/rules_nodejs-3.1.0.tar.gz"],
)

load("@build_bazel_rules_nodejs//:index.bzl", "yarn_install")

yarn_install(
    name = "npm",
    data = ["//:patches/@angular-devkit+architect-cli+0.900.1.patch"],
    package_json = "//:package.json",
    symlink_node_modules = False,
    yarn_lock = "//:yarn.lock",
)


