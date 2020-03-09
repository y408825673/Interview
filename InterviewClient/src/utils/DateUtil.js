export default {
  toDate (date) {
    let year = date.getYear() + 1900
    let month = date.getMonth() + 1
    let day = date.getDate()
    if (month < 10) month = '0'+month
    if (day < 10)  day = '0'+day
    return `${year}-${month}-${day}`
  },
  toDateObj (dateStr){
    let dateArr =  dateStr.split('-');
    return new Date(dateArr[0], dateArr[1], dateArr[2])
  }
}
