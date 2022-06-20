import config.provider.AccessProvider

class AccessProviderTest {

  @org.junit.jupiter.api.Test
  fun test() {
    val asd = AccessProvider().getAccessData("basicAuthProperties.yaml")

    println(asd.user)
    println(asd.pass)
    println(asd.host)
  }
}