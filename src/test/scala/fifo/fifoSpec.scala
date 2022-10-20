package fifo

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class FIFOSpec extends AnyFreeSpec with ChiselScalatestTester {
    "FIFO should be first in first out" in {
        test(new fifo(4, 2, 4)) { c =>

        c.io.wr_en(1.B)
        c.io.din(2.U)
        c.clock.step(1)
        c.io.full.expect(0.B)  

        c.io.wr_en(1.B)
        c.io.din(2.U)
        c.clock.step(1)
        c.io.full.expect(1.B)
            

        }
    }
}