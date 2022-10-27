// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See Valu.h for the primary calling header

#include "verilated.h"

#include "Valu__Syms.h"
#include "Valu___024root.h"

VL_ATTR_COLD void Valu___024root___configure_coverage(Valu___024root* vlSelf, bool first) {
    if (false && vlSelf) {}  // Prevent unused
    Valu__Syms* const __restrict vlSymsp VL_ATTR_UNUSED = vlSelf->vlSymsp;
    VL_DEBUG_IF(VL_DBG_MSGF("+    Valu___024root___configure_coverage\n"); );
    // Body
    if (false && first) {}  // Prevent unused
    vlSelf->__vlCoverInsert(&(vlSymsp->__Vcoverage[0]), first, "alu.v", 13, 9, ".alu", "v_branch/alu", "if", "13-14");
    vlSelf->__vlCoverInsert(&(vlSymsp->__Vcoverage[1]), first, "alu.v", 13, 10, ".alu", "v_branch/alu", "else", "16");
    vlSelf->__vlCoverInsert(&(vlSymsp->__Vcoverage[2]), first, "alu.v", 12, 5, ".alu", "v_line/alu", "block", "12");
}
