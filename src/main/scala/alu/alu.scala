package alu

import chisel3._

class alu extends Module {
  val io = IO(new Bundle {
    val a = Input(SInt(8.W))
    val b = Input(SInt(8.W))
    val op = Input(Bool())
    val output = Output(SInt(8.W))
  })
 
  // Rising edge of clock with RegNext
  val x = RegNext(io.a)
  val y = RegNext(io.b)
  when(io.op) {
      io.output := x + y
  }.otherwise {
      io.output := x - y
  }

}
