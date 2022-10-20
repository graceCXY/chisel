package counter

import chisel3._

class counter(width: Int) extends Module {
  // implicit clock and reset
  val x = Reg(UInt(2.W)) // implicitly clocked with the module clock
  val io = IO(new Bundle {
    // val clk = Input(Clock())
    val ce = Input(Bool())
    val output = Output(UInt(width.W))
  })
//   clock
//   reset
  val count = RegInit(UInt(width.W), 0.U)
  when(io.ce) {
    count := count + 1.U
  }
  io.output := count

//   val sec_count = Reg(UInt(32.W))
//   val clk_periods = Reg(UInt(32.W))
//   when(io.ce) {
//       clk_periods := clk_periods + io.clk
//       when(clk_periods === 1000000000.U){
//         println("in when")
//         // 1 second = 1 * 10^9 nano seconds 
//         // 1 clk period = 8ns 
//         // # cycles = 10^9 / 8 = 125000000
//         sec_count := sec_count + 1.U
//         clk_periods := 0.U
//         io.output := sec_count
//       }
//   }
//   io.output := 0.U
}


// package counter

// import chisel3._

// class counter extends Module {
//   val io = IO(new Bundle {
//     val clk = Input(UInt(32.W))
//     val ce = Input(Bool())
//     val output = Output(UInt(32.W))
//   })
 
//   val sec_count = Reg(UInt(32.W))
//   val clk_periods = Reg(UInt(32.W))

//   when(io.ce) {
//       clk_periods := clk_periods + io.clk
//       when(clk_periods === 1000000000.U){
//         println("in when")
//         // 1 second = 1 * 10^9 nano seconds 
//         // 1 clk period = 8ns 
//         // # cycles = 10^9 / 8 = 125000000
//         sec_count := sec_count + 1.U
//         clk_periods := 0.U
//         io.output := sec_count
//       }
//   }
//   io.output := 0.U

// }
