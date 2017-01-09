#include "LogMessage.h"

#include "gvrtest.h"

CLogMessage::CLogMessage(const char *funname)
{
    m_pFunName = funname;
    LOGI("FunName:%s, begin", m_pFunName);
}

CLogMessage::~CLogMessage()
{
    LOGI("FunName:%s, end", m_pFunName);
}

void ShowMessage(char *funname, int line)
{

}