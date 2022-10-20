package alu

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class ALUSpec extends AnyFreeSpec with ChiselScalatestTester {
    "alu should pass" in {
        test(new alu) { c =>
        // verify that the output of ALU is correct
        c.io.a.poke(2.S)
        c.io.b.poke(3.S)
        c.io.op.poke(1.B)
        c.clock.step(1)
        c.io.output.expect(5.S)  
            
        c.io.a.poke(-2.S)
        c.io.b.poke(-3.S)
        c.io.op.poke(1.B)
        c.clock.step(1)
        c.io.output.expect(-5.S) 
            
        c.io.a.poke(7.S)
        c.io.b.poke(3.S)
        c.io.op.poke(0.B)
        c.clock.step(1)
        c.io.output.expect(4.S)  
        }
    }
}