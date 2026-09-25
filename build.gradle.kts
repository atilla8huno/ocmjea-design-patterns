tasks.register("test") {
    group = "verification"
    description = "Runs tests in every module."
    dependsOn(subprojects.map { it.tasks.named("test") })
}
