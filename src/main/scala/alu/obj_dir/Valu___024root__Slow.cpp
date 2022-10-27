// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See Valu.h for the primary calling header

#include "verilated.h"

#include "Valu__Syms.h"
#include "Valu___024root.h"

void Valu___024root___ctor_var_reset(Valu___024root* vlSelf);

Valu___024root::Valu___024root(Valu__Syms* symsp, const char* name)
    : VerilatedModule{name}
    , vlSymsp{symsp}
 {
    // Reset structure values
    Valu___024root___ctor_var_reset(this);
}

void Valu___024root___configure_coverage(Valu___024root* vlSelf, bool first);

void Valu___024root::__Vconfigure(bool first) {
    if (false && first) {}  // Prevent unused
    Valu___024root___configure_coverage(this, first);
}

Valu___024root::~Valu___024root() {
}

// Coverage
void Valu___024root::__vlCoverInsert(uint32_t* countp, bool enable, const char* filenamep, int lineno, int column,
    const char* hierp, const char* pagep, const char* commentp, const char* linescovp) {
    uint32_t* count32p = countp;
    static uint32_t fake_zero_count = 0;
    if (!enable) count32p = &fake_zero_count;
    *count32p = 0;
    VL_COVER_INSERT(vlSymsp->_vm_contextp__->coveragep(), count32p,  "filename",filenamep,  "lineno",lineno,  "column",column,
        "hier",std::string{name()} + hierp,  "page",pagep,  "comment",commentp,  (linescovp[0] ? "linescov" : ""), linescovp);
}
