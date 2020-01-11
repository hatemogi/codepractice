package e08

import common.GenUtil.smallList
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object AllSubsetsSpecification extends Properties("부분집합") {
  import AllSubsets._

  property("[집합의 수 == 2^n개]") = forAll(smallList()) { xs =>
    subsets(xs).size == Math.pow(2, xs.size)
  }

  property("[공집합이 있어야]") = forAll(smallList()) { xs =>
    subsets(xs) contains Nil
  }

  property("[전체집합이 있어야]") = forAll(smallList()) { xs =>
    subsets(xs) contains xs
  }

  property("[앞부분/뒷부분 집합들을 다 포함해야]")
    = forAll(smallList().filterNot(_.isEmpty)) { xs: List[Int] =>
    val ys = subsets(xs)
    (0 to xs.size).forall { n =>
      ys.contains(xs take n) && ys.contains(xs drop n)
    }
  }
}