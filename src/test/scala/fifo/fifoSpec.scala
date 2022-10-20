package fifo

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class FIFOSpec extends AnyFreeSpec with ChiselScalatestTester {
    "FIFO should be first in first out" in {
        test(new fifo(8, 2, 4)).withAnnotations(Seq(WriteVcdAnnotation)) { c =>
            c.io.din.poke(10.U)
            c.io.din_valid.poke(0.U)
            c.clock.step(1)
            c.io.din_valid.poke(1.U)
            c.clock.step(1)
            c.io.din.poke(15.U)
            c.clock.step(1)
            c.io.din_ready.expect(0.B)
        }
    }
}
