package fifo

import chisel3._ 

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

class fifo(Width:Int, Depth:Int, PointerWidth:Int) extends Module {
    val queue_length = RegInit(0.U)
    val enqueue = new node(Width.U)
    val dequeue = new node(Width.U)

    enqueue.next_node := dequeue
    dequeue.next_node := enqueue

    val io = IO(new Bundle {

        //write side
        val wr_en = Input(Bool())
        val din = Input(Width.U)
        val full = Output(Bool())

        //read side
        val rd_en = Input(Bool())
        val dout = Output(Width.U)
        val empty = Output(Bool())
    
    })

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
}