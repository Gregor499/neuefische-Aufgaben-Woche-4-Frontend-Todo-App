import {Task} from "./model";
import './Style.css';

interface TaskProps {
    task: Task
}

export default function TaskOutput(props: TaskProps) {
    return (
        <div className="task">
            <br/>
            <div className="task-information">
                <div>
                    <span className="label">Id:</span> {props.task.id}
                </div>
                <div>
                    <span className="label">Task:</span> {props.task.task}
                </div>
                <div>
                    <span className="label">Description:</span> {props.task.description}
                </div>
                <div>
                    <span className="label">Status:</span> {props.task.status}
                </div>
                <div>
                    <button className="button2" /*onClick={setPrevious}*/>previous</button>
                    <button className="button2" /*onClick={setNext}*/>next</button>
                    <button className="button2" /*onClick={setDelete}*/>delete</button>
                    <button className="button2" /*onClick={setedit}*/>edit</button>
                </div>
            </div>
        </div>
    )
}