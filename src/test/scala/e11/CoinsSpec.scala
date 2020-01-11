package e11

import org.scalatest.flatspec.AnyFlatSpec

class CoinsSpec extends AnyFlatSpec {
  import Coins._

  "minCoins" should "최소의 동전으로 원하는 액수를 만들어야 한다" in {
    assert(minCoins(List(1, 3, 4), 6) == List(3, 3))
  }
}