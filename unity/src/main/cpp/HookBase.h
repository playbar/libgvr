#pragma once

// struct HookParamet
// {
// 	char szFunctionName[128];
// 	void *fpHookToFunction;
// 	void *fpRealFunction;
// };
class HookBase
{
public:
	HookBase();
	virtual ~HookBase();
	
	static bool HookToFunction(void * hDLL , const char * szFunctionName , void * fpReplactToFunction , void ** fpOutRealFunction);
};

