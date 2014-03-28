//
//  ViewController.m
//  RGBSlider
//
//  Created by Andreas on 19.03.13.
//  Copyright (c) 2013 Andreas. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)sliderChanged:(id)sender {
    UIColor* color = [[UIColor alloc]initWithRed:self.sliderRed.value green:self.sliderGreen.value blue:self.sliderBlue.value alpha:1];
    self.view.backgroundColor = color;
}
@end
