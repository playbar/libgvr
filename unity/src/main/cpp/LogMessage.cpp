#include "LogMessage.h"

#include "gvrglobal.h"

CLogMessage::CLogMessage(const char *funname)
{
    m_pFunName = funname;
    LOGI("mjgvr F:%s, begin", m_pFunName);
}

CLogMessage::~CLogMessage()
{
    LOGI("mjgvr F:%s, end", m_pFunName);
}

void ShowMessage(char *funname, int line)
{

}