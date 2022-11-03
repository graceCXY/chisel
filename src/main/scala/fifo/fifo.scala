package fifo

import chisel3._ 
import chisel3.util._
/*
class node(Width:Int) extends Module {
    val io = IO(new Bundle{
        val prev = Input(Width.U)
        val next = Input(Width.U)
        val value = Input(Width.U)
        val output = Output(Width.U)
    })
    val prev_node = RegNext(io.prev)
    val next_node = RegNext(io.next)
    val node_val = RegNext(io.value)

    io.output := node_val
}
*/

class fifo(Width:Int, Depth:Int) extends Module {
    val io = IO(new Bundle {

        //write side (enqueueing)
        val din = Input(UInt(Width.W))
        val din_valid = Input(Bool())
        val din_ready = Output(Bool())

        //read side (dequeueing)
        val dout = Output(UInt(Width.W))
        val dout_valid = Output(Bool())
        val dout_ready = Input(Bool())
    })

    val entries = Reg(Vec(Depth, UInt(Width.W)))
    val wrPtr = RegInit(UInt(log2Ceil(Depth).W), 0.U)
    val rdPtr = RegInit(UInt(log2Ceil(Depth).W), 0.U)
    val nElem = RegInit(UInt(log2Ceil(Depth+1).W), 0.U)

    io.din_ready := nElem < Depth.U
    when(io.din_valid && io.din_ready) {
        // println(nElem)
        entries(wrPtr) := io.din
        nElem := nElem + 1.U
        wrPtr := wrPtr + 1.U
        when(wrPtr === (Depth-1).U) {
            wrPtr := 0.U
        }
    }

    io.dout_valid := nElem > 0.U
    io.dout := entries(rdPtr)
    when(io.dout_valid && io.dout_ready) {
        printf("read")
        nElem := nElem - 1.U
        rdPtr := rdPtr + 1.U 
        when(rdPtr === (Depth-1).U) {
            // print("0")
            rdPtr := 0.U
        }
    }
}






/*
    val queue_length = RegInit(0.U)
    val enqueue = new node(Width.U)
    val dequeue = new node(Width.U)

    enqueue.next_node := dequeue
    dequeue.next_node := enqueue


    when(io.wr_en){
        when(queue_length < Depth) {
            val new_node = new node(Width)
            new_node.value := RegNext(din)
            new_node.prev_node := enqueue
            new_node.next_node := enqueue.next_node
            enqueue.next_node.prev_node := new_node
            enqueue.next_node := new_node
            queue_length = queue_length + 1.U
        }
        when(queue_length === Depth.U) {
            io.full := 1.B
        }.elsewhen {
            io.full := 0.B
        }
    }

    when(io.rd_en){
        when(queue_length > 0) {
            val pop_node = dequeue.prev_node
            io.dout := pop_node.node_val

            dequeue.prev_node.prev_node.next_node := dequeue
            dequeue.prev_node := dequeue.prev_node.prev_node
        
        }
        when(queue_length === 0.U) {
            io.empty := 1.B
        }.elsewhen {
            io.empty := 0.B
        }
    }
    */

