// Clock Script Generated By Maxx Blade's Clock v2.0d
// http://www.maxxblade.co.uk/clock
function timeSource(){
   x=new Date();
   x.setTime(x.getTime());
   return x;
}
function leadingZero(x){
   return (x>9)?x:'0'+x;
}
function twelveHour(x){
   if(x==0){
      x=12;
   }
   return (x>12)?x-=12:x;
}
function displayTime(){
   document.getElementById('divClock').innerHTML=eval(outputTime);
   setTimeout('displayTime()',1000);
}
function amPMsymbol(x){
   return (x>11)?'PM':'AM';
}
function fixYear4(x){
   return (x<500)?x+1900:x;
}

var dayNames=new Array('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday');
var monthNames=new Array('Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec');
var outputTime="dayNames[timeSource().getDay()]+' | ' + monthNames[timeSource().getMonth()] + ' ' + leadingZero(timeSource().getDate()) + ' ' + fixYear4(timeSource().getYear())+' '+twelveHour(timeSource().getHours())+':'+leadingZero(timeSource().getMinutes())+':'+leadingZero(timeSource().getSeconds()) + ' ' + amPMsymbol(timeSource().getHours())";