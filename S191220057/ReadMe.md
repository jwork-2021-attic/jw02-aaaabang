## 任务一

1. ##### 用plantuml画出example的类图与Scene中main方法执行过程中的对象时序图；

![](http://www.plantuml.com/plantuml/png/LPAxKWCn34LxVOLBO2Rv12QaIKEHuK73K2Y923iuzeuV0-7nxmZxxgutZQMRwsEjf5LC758-MQBE9Gcll1TpxuE6vfkC_gpdmyLb2QFg28-IjfQTPhz4UyincdNUxQpCxYho-SLmlVp1VMk_xPp0jlMnIvrtwkqHHYh_zBbv457oDo7mkMKD0F0KpLgAiVMSlG58b0HNvKmV3nceEP-6knFDeBf66fGdjXbuSVbaDZw7mzGP4yReE4QxMR5e1nwkW8bVqlNvZjqxn80GxGPcDgMDoDSu7mmhbeC6xiERL1TGICR6rLl8jSVos2FfEKJ1NlpdyYdxdD03ejc6B9S_roY025Kj5b0WgAdiIPDEewZjB1ZC399I9bTPiwjMWbbjll6jn1tooT8V)





##### 2.尝试从面向对象编程角度理解`example`的设计理念，具体阐述这样写的好处与可改进之处（越详细越好）；

**设计理念：**将问题中的元素划分为排序器、爷爷、葫芦娃、队列。他们需要完成的任务独立且高效，Geezer使用Sorter，向Gourd发送消息，Gourd在Line中移动。根据问题描述问题。

**好处：**1）代码可复用性强

低耦合：比如，如果后续添加多种排序功能，只需新增新的class表示新排序算法，排序算法的切换不影响Geezer对排序器的使用，Geezer模块代码不需要改动。

高内聚：比如，对于排序的场景，Geezer发出交换命令和Gourd交换行为分开，这样即使交换命令规范（从小到大排或从大到小排）发生改变，交换行为模块也不会受到影响。

2）（要在sorter里定义个getPlan，然后让老爷爷把plan拆成step，再叫葫芦娃swap？为什么我不直接用sorter去将line里的position数组排序？）

更符合人类对问题的抽象和理解，按照问题划分对象解决问题，Line是独立的队列，发出排序命令的是Geezer，Gourd接收命令并移动。对象之间相互独立协作，分工明确，不会引起混乱，提高重用性，低耦合的设计可以降低软件开发后期的维护。

如果Sorter可直接更改Line中的信息，那么其他类也可以通过Sorter改变葫芦娃的排序（被蛇精操控的风险），但能向葫芦娃发出命令应该只有爷爷。



**可改进之处：**

编码规范化，类中对象声明应该放在方法前，按照编译器执行顺序也是先定义对象再到方法，这样的写法也使在方法中使用对象有迹可循。

## 任务二

可视化结果展示链接:https://asciinema.org/a/438925

类图

![](http://www.plantuml.com/plantuml/png/TL9DJyCm3BtdL-G8IDjFG6Dda0O3BeY3rvbHBMjBamWcuBzZnNRT7DXbp-xpo_F7AYOOKpu5vzekuVW63VfjFnBqtyxJB_ImlxWiC59Uu07J9a17qQzpJO0O_JhlTW6hMf9yUVN0nPympEdtkMsEp7R_iGlyKAB40nbkKzlpuonsstOeRsxwMBwIr20mEYxCvbvHwc_64SvpOoeWUYGDr9SF_5-zeNF192pMiKbAMgHgVQUrfkRLdQKqymmXa_mq76EOypjgjHg-7oTqcD3Ela9thFhHYPataPo_iktWg1t9jYElKRq-lcCXYLt58iar4jDKyMcmpKQKir8jCR0-Fv1PuU4NDZd9i9sh3c-v_BaMMyvEhCuxRc6na0J7H2btP95jIbomYYnrIfAECSibNirJGYTQF-EjiDldK_W3)

## 任务三

可视化结果展示链接:

类图
