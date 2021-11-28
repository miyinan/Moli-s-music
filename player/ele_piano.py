import tkinter as tk
import os
import re
import time
import pygame

pygame.mixer.init()


def play_piano():
    notes = {"do.m": 'C3', "re.m": 'D3', "me.m": 'E3', "fa.m": 'F3', "so.m": 'G3', "la.m": 'A3', "si.m": 'B3',
             "do.l": 'C2', "re.l": 'D2', "me.l": 'E2', "fa.l": 'F2', "so.l": 'G2', "la.l": 'A2', "si.l": 'B2',
             "do.h": 'C4', "re.h": 'D4', "me.h": 'E4', "fa.h": 'F4', "so.h": 'G4', "la.h": 'A4', "si.h": 'B4',
             "do.hh": 'C5', "re.hh": 'D5', "me.hh": 'E5', "fa.hh": 'F5', "so.hh": 'G5', "la.hh": 'A5', "si.hh": 'B5',"kong":'kong'}
    filename=entry_filename.get()
    speed = int(entry_speed.get())
    list = get_note(filename)
    global beats
    for note in list:
        bn_ = re.findall("[0123456789\.]*", note)
        fq_ = re.findall("\D{4,5}", note)
        if len(fq_) == 0:
            bn_ = ['0']
            fq_ = ['0']
            print('end')
            time.sleep(0.2)
            continue
        else:
            name = notes[fq_[0]]
            beats = float(60 / speed)
            print('bn_0：'+bn_[0])
            bn = float(bn_[0]) * beats
            if name =='kong':
                print(name)
                print(bn)
                time.sleep(bn)
                continue
            file = r"./sound/%s.mp3" % (name)
            pygame.mixer.music.load(file)
            pygame.mixer.music.play()
            print(bn)
            time.sleep(bn)
            pygame.mixer.music.stop()
            # while pygame.mixer.music.get_busy():
            # time.sleep(1)


def get_note(filename):
    file = open(r'./sheet_music/%s.txt' %filename)
    line = file.read()
    list = line.split()
    return list



def play_():
    mode=var.get()
    if mode=='beep':
        play_beep()
    if mode=='piano':
        play_piano()


def play_beep():
    file=entry_filename.get()
    speed=int(entry_speed.get())
    list=get_note(file)
    global beats
    notes={"do.m":262,"re.m":296,"me.m":330,"fa.m":349,"so.m":392,"la.m":440,"si.m":494,
           "do.l":131,"re.l":147,"me.l":165,"fa.l":175,"so.l":196,"la.l":220,"si.l":247,
           "do.h":523,"re.h":587,"me.h":659,"fa.h":698,"so.h":784,"la.h":880,"si.h":988,
           "do.hh":1047,"re.hh":1175,"me.hh":1319,"fa.hh":1397,"so.hh":1568,"la.hh":1760,"si.hh":1976 }
    beats=60/speed*1000
    for note in list:
        bn_ = re.findall("[0123456789\.]*", note)
        fq_ = re.findall("\D{4,5}", note)
        if len(fq_)==0:
            bn_=['0']
            fq_=['0']
            time.sleep(0.3)
            continue
        else:
            if fq_[0] =='kong':
                print(fq_[0])
                print(bn)
                time.sleep(bn)
                continue
            fq=notes[fq_[0]]
            beats=60/speed
            bn=float(bn_[0])*beats
            os.system('play --no-show-progress --null --channels 1 synth %s sine %f'%( bn, fq))
        print(fq_,bn_)
        print(fq,bn)


def beep_up():
    bn = 0.5
    fq = 200
    while fq <= 2000:
        os.system('play --no-show-progress --null --channels 1 synth %s sine %f' % (bn, fq))
        fq = fq + 200
        print(fq)






window = tk.Tk()
window.title("molimoli's player")
window.geometry("400x250")
# welcome image
canvas = tk.Canvas(window, height=112, width=401)#创建画布
image_file = tk.PhotoImage(file='./img/welcome.gif')#加载图片文件
image = canvas.create_image(0,0, anchor='nw', image=image_file)#将图片置于画布上
canvas.pack(side='top')#放置画布（为上端）
#文字组件
tk.Label(window,text='SPEED:').place(x=210,y=120)
tk.Label(window,text='曲名:').place(x=50,y=120)
tk.Label(window,text='选择音色:').place(x=50,y=180)
#输入框组件
var_file=tk.StringVar()
entry_filename=tk.Entry(window,textvariable=var_file,width=12)
entry_filename.place(x=90,y=120)
var_speed=tk.StringVar()
entry_speed=tk.Entry(window,textvariable=var_speed,width=3)
entry_speed.place(x=260,y=120)

#音色选项组件
var=tk.StringVar()
r1 = tk.Radiobutton(window, text='钢琴音色',variable=var,value='piano')
r1.place(x=120,y=180)
#var2=tk.StringVar()
r2 = tk.Radiobutton(window, text='蜂鸣器音色',variable=var,value='beep')
r2.place(x=200,y=180)

btn_beep = tk.Button(window, text='BEEP', command=beep_up)
btn_beep.place(x=320, y=120)
btn_play = tk.Button(window, text='PLAY', command=play_)
btn_play.place(x=320, y=180)

window.mainloop()
