// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See Valu.h for the primary calling header

#include "verilated.h"

#include "Valu__Syms.h"
#include "Valu___024root.h"

VL_INLINE_OPT void Valu___024root___sequent__TOP__0(Valu___024root* vlSelf) {
    if (false && vlSelf) {}  // Prevent unused
    Valu__Syms* const __restrict vlSymsp VL_ATTR_UNUSED = vlSelf->vlSymsp;
    VL_DEBUG_IF(VL_DBG_MSGF("+    Valu___024root___sequent__TOP__0\n"); );
    // Body
    ++(vlSymsp->__Vcoverage[2]);
    if (vlSelf->op) {
        ++(vlSymsp->__Vcoverage[0]);
        vlSelf->out = (0xffU & ((IData)(vlSelf->a) 
                                + (IData)(vlSelf->b)));
    } else {
        vlSelf->out = (0xffU & ((IData)(vlSelf->a) 
                                - (IData)(vlSelf->b)));
    }
    if ((1U & (~ (IData)(vlSelf->op)))) {
        ++(vlSymsp->__Vcoverage[1]);
    }
}
