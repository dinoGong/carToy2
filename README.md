# carToy2


以下是arduino nano板子中要烧录的代码：


```arduino
void setup()
{
  Serial.begin(9600);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(12, OUTPUT);
}
void loop()
{
  while(Serial.available())
   {
     char c=Serial.read();
      if(c=='1') //  up
        {
          digitalWrite(9, HIGH);
          digitalWrite(10, LOW);
          digitalWrite(11, HIGH);
          digitalWrite(12, LOW);
        }
        if(c=='2')//down
        {
          digitalWrite(10, HIGH);
          digitalWrite(9, LOW);
          digitalWrite(12, HIGH);
          digitalWrite(11, LOW);
        }
        if(c=='3')//left
        {
          digitalWrite(9, HIGH);
          digitalWrite(10, LOW);
          digitalWrite(11, LOW);
          digitalWrite(12, LOW);
        }
        if(c=='4')//right
        {
          digitalWrite(11, HIGH);
          digitalWrite(12, LOW);
          digitalWrite(9, LOW);
          digitalWrite(10, LOW);
        }
         if(c=='5')//stop
        {
          digitalWrite(9, LOW);
          digitalWrite(10, LOW);
          digitalWrite(11, LOW);
          digitalWrite(12, LOW);
        }
        Serial.write(c);
   }
}

```


可以使用的蓝牙有：

CC41-A
JDY-10

这两个都是从机蓝牙4.0模块。

需要注意的是，蓝牙要接3.3v，刚好arduino nano 有。
 
