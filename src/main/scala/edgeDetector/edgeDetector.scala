package edgeDetector
import chisel3._
class edgeDetector(width: Int) extends Module {
  val io = IO(new Bundle {
    val signal_in = Input(Vec(width, Bool()))
    val edge_detect_pulse = Output(UInt(width.W))
  })
//     val signal_prev = Reg(UInt(width.W))
//     val is_rising_edge = Reg(UInt(width.W))
//     (0 until width).forEach { i =>
//       when (signal_prev(i) === 0.U && io.signal_in(i) === 1.U) {
//           is_rising_edge(i) := 1.U
//       }.otherwise {
//           is_rising_edge(i) := 0.U
//       }
//     }
//     signal_prev := io.signal_in
//     io.edge_detect_pulse := is_rising_edge
}


// package edgeDetector

// import chisel3._

// class edgeDetector extends Module {
//   val io = IO(new Bundle {
//     val clk = Input(UInt(8.W))
//     val signal_in = Input((UInt(1.W)))
//     val edge_detect_pulse = Output(UInt(1.W))
//   })
//     val signal_prev = Reg(UInt(1.W))

//     val is_rising_edge = Reg(UInt(1.W))
//     when (signal_prev === 0.U && io.signal_in === 1.U) {
//         is_rising_edge := 1.U
//     }.otherwise {
//         is_rising_edge := 0.U
//     }
//     signal_prev := io.signal_in
  
//     io.edge_detect_pulse := is_rising_edge
// }
