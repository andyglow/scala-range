package scalax.range

import org.scalatest._
import org.scalatest.Matchers._


class ExcIncSpec extends WordSpec {

  "Inclusiveness" should {

    "be reflected from left" in {
      (inclusive(0) until 1 by 1).toList should contain only 0
    }

    "be reflected from right" in {
      (exclusive(0) to 1 by 1).toList should contain only 1
    }

    "be reflected from both sides" in {
      (inclusive(0) to 1 by 1).toList should contain inOrder(0, 1)
    }

    "be reflected from both sides (empty)" in {
      (exclusive(0) until 1 by 1).toList shouldBe 'empty
    }
  }
}
