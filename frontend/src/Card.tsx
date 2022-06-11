import React, {useEffect, useState} from "react";
import TaskOutput from "./TaskOutput";
import {Task} from "./model";
import './Style.css';
import InputNewTask from "./InputNewTask";

export default function Card() {

    const [list, setList] = useState<Task[]>([]);

    const [error, setError] = useState("")

    function refresh() {
        fetch("http://localhost:8080/api/react", {
            method: "GET",
        })
            .then(response => response.json())
            .then(tasks => setList(tasks))
            .catch(err => setError("error"));
    }

    useEffect(() => {
        refresh();
    }, []);


    const getList = () => {
        return list.map(t => <TaskOutput
            task={{id: t.id, task: t.task, description: t.description, status: t.status}}/>)
    }

    return (
        <div>
            <div className="input-card">
                <InputNewTask refreshFunction={refresh}/>
            </div>

            <div className="tasks">
                <u>Aufgaben:</u>
                {getList()}
            </div>
        </div>
    )
}