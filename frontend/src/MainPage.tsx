import React, { useState, useEffect } from 'react';
import Card from "./Card";
import InputNewTask from "./InputNewTask";
import './Style.css';

export default function MainPage() {
    return (
        <div className ="app">
            <div className="headline">
                <h1>TodoApp</h1>
            </div>
            <div className="card">
                <Card />
            </div>
        </div>
    );
}