#ifndef __LOGMESSAGE__H_
#define __LOGMESSAGE__H_

class CLogMessage
{
public:
    CLogMessage(const char *funname);
    ~CLogMessage();
    void ShowMessage(char *funname, int line);

private:
    const char *m_pFunName;
};


#endif

