package counter

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class COUNTERSpec extends AnyFreeSpec with ChiselScalatestTester {
    "Counter should output number of seconds" in {
        test(new counter(2)) { c =>
            // // verify that the output of counter is correct
            //c.io.clk.poke(8.U)
            // c.io.ce.poke(1.B)
            // c.clock.step(1)
            // c.io.output.expect(1.U)

            // c.clock.step(3) // 2, 3, 0
            // c.io.output.expect(0.U)
            // c.io.ce.poke(0.B)
            // c.clock.step(3)
            // c.io.output.expect(0.U)
        }
    }
}
// package counter

// import chisel3._
// import chiseltest._
// import org.scalatest.freespec.AnyFreeSpec
// import chisel3.experimental.BundleLiterals._

// class COUNTERSpec extends AnyFreeSpec with ChiselScalatestTester {
//     "Counter should output number of seconds" in {
//         test(new counter) { c =>
//             // // verify that the output of counter is correct
//             c.io.clk.poke(8.U)
//             c.io.ce.poke(1.B)
//             c.clock.step(1)
//             c.io.output.expect(0.U)

//             // c.clock.setTimeout(2)
//             c.io.clk.poke(1000000000.U)
//             c.io.ce.poke(1.B)
//             c.clock.step(1)
//             c.io.output.expect(1.U)
//         }
//     }
// }