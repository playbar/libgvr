#ifndef _INSTRUCTION_H_
#define _INSTRUCTION_H_

#include <stdio.h>

#ifdef __cplusplus
extern "C" {
#endif

void relocateInstructionInThumb(uint32_t target_addr, uint16_t *orig_instructions, int length,
                                uint16_t *trampoline_instructions, int *orig_boundaries,
                                int *trampoline_boundaries, int *count);

void relocateInstructionInArm(uint32_t target_addr, uint32_t *orig_instructions, int length,
                              uint32_t *trampoline_instructions, int *orig_boundaries,
                              int *trampoline_boundaries, int *count);

void relocateInstruction_1(uint32_t target_addr, void *orig_instructions, int length,
                         void *trampoline_instructions, int *orig_boundaries,
                         int *trampoline_boundaries, int *count);

#ifdef __cplusplus
}
#endif

#endif //_INSTRUCTION_H_