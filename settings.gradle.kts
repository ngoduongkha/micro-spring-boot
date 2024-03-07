rootProject.name = "micro-spring-boot"

includeBuild("platforms")
includeBuild("build-logic")

includeBuild("services/discovery-server")
includeBuild("services/api-gateway")
includeBuild("services/product-service")
includeBuild("services/order-service")

//includeBuild("aggregation")
//
//includeBuild("user-feature")
//includeBuild("admin-feature")
//
//includeBuild("server-application")
//includeBuild("android-app")
