/**
 * api接口统一管理
 */
import { post } from './http'

export const getInterviewer = p => post('/getInterviewer', p)
